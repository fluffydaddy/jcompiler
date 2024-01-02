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

public interface CompilerFactory<T extends Template,
        C extends Compiler,
        S extends Console,
        O extends Optimizer,
        P extends Project> {
    T createTemplate(String projects);
    
    C createCompiler(T template);
    
    S createConsole();
    
    O createOptimizer(P project);
}