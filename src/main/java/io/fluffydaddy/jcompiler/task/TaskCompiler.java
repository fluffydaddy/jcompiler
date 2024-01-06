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

package io.fluffydaddy.jcompiler.task;

import java.io.File;
import java.io.Writer;

/**
 * Interface representing a task compiler.
 */
public interface TaskCompiler {
    /**
     * Add a task listener to the compiler.
     *
     * @param taskListener The task listener to be added.
     */
    void addTaskListener(TaskListener taskListener);
    
    /**
     * Remove a task listener from the compiler.
     *
     * @param taskListener The task listener to be removed.
     */
    void removeTaskListener(TaskListener taskListener);
    
    /**
     * Configure the compiler with the given options.
     *
     * @param options The options to configure the compiler.
     * @return True if the configuration was successful, false otherwise.
     */
    boolean configure(String... options);
    
    /**
     * Remove the specified options from the compiler.
     *
     * @param options The options to be removed.
     * @return True if all specified options were successfully removed, false otherwise.
     */
    boolean removeOptions(String... options);
    
    /**
     * Remove all options from the compiler.
     */
    void removeOptions();
    
    /**
     * Check if the specified option is supported by the compiler.
     *
     * @param option The option to check.
     * @return True if the option is supported, false otherwise.
     */
    boolean isOption(String option);
    
    /**
     * Set the sources for compilation recursively from the specified source path.
     *
     * @param sourcePath The source directory from which files are taken recursively.
     */
    void setSources(String sourcePath);
    
    /**
     * Set the sources for compilation recursively from the specified source directory.
     *
     * @param srcDirectory The source directory from which files are taken recursively.
     */
    void setSources(File srcDirectory);
    
    /**
     * Remove all source files for compilation.
     */
    void removeSources();
    
    /**
     * Get the output writer for compilation.
     *
     * @return The output writer.
     */
    Writer getOutput();
    
    /**
     * Get the error writer for compilation.
     *
     * @return The error writer.
     */
    Writer getError();
    
    /**
     * Process the compilation/generation of files.
     *
     * @return True if the compilation was successful, false otherwise.
     */
    boolean process();
}
