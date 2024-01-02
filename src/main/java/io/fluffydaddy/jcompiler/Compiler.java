/*
 * Copyright © 2024 fluffydaddy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fluffydaddy.jcompiler;

import io.fluffydaddy.jcompiler.task.TaskCompiler;
import io.fluffydaddy.jcompiler.task.TaskListener;
import io.fluffydaddy.jtasks.impl.TaskService;
import io.fluffydaddy.reactive.DataSubscription;
import io.fluffydaddy.reactive.ErrorObserver;

public abstract class Compiler<C extends TaskCompiler> implements Task<C>, Runnable, DataSubscription {
    protected final TaskListener taskListener;
    
    private boolean isCanceled = false;
    
    private volatile C taskCompiler;
    protected final TaskService<Void, Void> taskExecutor;
    protected final ErrorObserver errorObserver;
    
    public Compiler(TaskListener listener, ErrorObserver errorObserver) {
        this.taskListener = listener;
        this.errorObserver = errorObserver;
        this.taskExecutor = new TaskService<>() {
            @Override
            public Void doInBackground(Void param) {
                Compiler.this.run();
                return null;
            }
            
            @Override
            public void onExecute() {
                taskPrepare();
            }
        };
    }
    
    public void start() {
        taskExecutor.execute();
    }
    
    @Override
    public boolean isCanceled() {
        return isCanceled;
    }
    
    @Override
    public void cancel() {
        isCanceled = true;
    }
    
    @Override
    public void run() {
        if (isCanceled()) {
            return;
        }
        
        if (taskCompiler == null) {
            taskStarted(taskCompiler = createRxCompiler(), false);
        } else {
            taskStarted(taskCompiler, true);
        }
        
        // log error
        // log debug
        // log output
        
        boolean lastRetCompile = false;
        try {
            lastRetCompile = taskCompile(taskCompiler);
        } catch (Throwable e) {
            errorObserver.onError(e);
        } finally {
            taskDestroy(taskCompiler, lastRetCompile);
        }
    }
}
