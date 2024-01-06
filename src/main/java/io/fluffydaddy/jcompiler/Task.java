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

import java.io.IOException;

/**
 * Interface representing a task with methods for creating a compiler, preparing the task,
 * starting the task, destroying the task, and compiling.
 *
 * @param <C> The type of the task compiler.
 */
public interface Task<C extends TaskCompiler> {
    /**
     * Create a reactive compiler for the task.
     *
     * @return The reactive compiler for the task.
     */
    C createRxCompiler();
    
    /**
     * Prepare the task.
     */
    void taskPrepare();
    
    /**
     * Notify that the task has started.
     *
     * @param compiler      The task compiler.
     * @param alreadyExists True if the task already exists, false otherwise.
     */
    void taskStarted(C compiler, boolean alreadyExists);
    
    /**
     * Destroy the task.
     *
     * @param compiler       The task compiler.
     * @param successCompile True if the compilation was successful, false otherwise.
     */
    void taskDestroy(C compiler, boolean successCompile);
    
    /**
     * Compile the task.
     *
     * @param compiler The task compiler.
     * @return True if the compilation was successful, false otherwise.
     * @throws IOException If an I/O error occurs during compilation.
     */
    boolean taskCompile(C compiler) throws IOException;
}
