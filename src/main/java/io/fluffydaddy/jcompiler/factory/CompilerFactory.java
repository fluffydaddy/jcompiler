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

package io.fluffydaddy.jcompiler.factory;

import io.fluffydaddy.jcompiler.Compiler;
import io.fluffydaddy.jcompiler.Optimizer;
import io.fluffydaddy.jcompiler.Project;
import io.fluffydaddy.jcompiler.Template;
import io.fluffydaddy.jconsole.Console;

/**
 * Factory interface for creating instances of various components in the compiler system.
 *
 * @param <T> Type of template.
 * @param <C> Type of compiler.
 * @param <S> Type of console.
 * @param <O> Type of optimizer.
 * @param <P> Type of project.
 */
public interface CompilerFactory<T extends Template,
        C extends Compiler,
        S extends Console,
        O extends Optimizer,
        P extends Project> {
    /**
     * Create a template with the specified projects path.
     *
     * @param projectsPath The path to projects.
     * @return An instance of the template.
     */
    T createTemplate(String projectsPath);
    
    /**
     * Create a compiler based on the provided template.
     *
     * @param template The template to use for compilation.
     * @return An instance of the compiler.
     */
    C createCompiler(T template);
    
    /**
     * Create a console for the compiler system.
     *
     * @return An instance of the console.
     */
    S createConsole();
    
    /**
     * Create an optimizer for the specified project.
     *
     * @param project The project for which the optimizer is created.
     * @return An instance of the optimizer.
     */
    O createOptimizer(P project);
}
