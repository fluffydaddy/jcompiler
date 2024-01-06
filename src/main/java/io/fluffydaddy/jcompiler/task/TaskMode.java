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

/**
 * Enum representing different modes of compilation tasks.
 */
public enum TaskMode {
    /**
     * Generate sources mode.
     */
    GENERATE_SOURCES,
    
    /**
     * Compile the generated files.
     */
    COMPILE_GENERATE,
    
    /**
     * Compile sources mode.
     */
    COMPILE_SOURCES;
    
    /**
     * Get a human-readable description of the compilation mode.
     *
     * @return A description of the compilation mode.
     */
    public String getDescription() {
        switch (this) {
            case GENERATE_SOURCES:
                return "Generate sources mode.";
            case COMPILE_GENERATE:
                return "Compile the generated files.";
            case COMPILE_SOURCES:
                return "Compile sources mode.";
            default:
                throw new UnsupportedOperationException("Unsupported compilation mode.");
        }
    }
}
