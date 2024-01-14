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

import io.fluffydaddy.jreactive.DataSubscriber;
import io.fluffydaddy.jreactive.ErrorObserver;

/**
 * Interface for the optimizer component in the compiler system.
 */
public interface Optimizer extends DataSubscriber<ErrorObserver> {
    /**
     * Optimize the code from the specified input path and save the optimized code to the output path.
     *
     * @param inputPath  The path to the input code.
     * @param outputPath The path to save the optimized code.
     */
    void optimize(String inputPath, String outputPath);
}
