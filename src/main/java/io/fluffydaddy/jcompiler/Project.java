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

import io.fluffydaddy.jhelper.files.FileHandle;

import java.io.IOException;
import java.util.Map;

/**
 * Interface representing a project with methods for initialization, cleaning, deletion, and more.
 */
public interface Project {
    /**
     * Initialize the project with the provided resources.
     *
     * @param resources The resources to initialize the project.
     * @throws IOException If an I/O error occurs during project initialization.
     */
    void init(Map<String, FileHandle> resources) throws IOException;
    
    /**
     * Clean the project.
     */
    void clean();
    
    /**
     * Delete the project.
     */
    void delete();
    
    /**
     * Check if the project is a release version.
     *
     * @return True if the project is a release version, false otherwise.
     */
    default boolean isRelease() {
        return false;
    }
    
    /**
     * Export the main file of the project (e.g., Main.java or Main.class).
     *
     * @param isCompiled True if the file to export is compiled, false if it is the source file.
     * @return The handle to the exported file.
     */
    FileHandle export(boolean isCompiled);
    
    /**
     * Check if the project exists.
     *
     * @return True if the project exists, false otherwise.
     */
    boolean exists();
    
    /**
     * Get the name of the project.
     *
     * @return The name of the project.
     */
    String getProjectName();
    
    /**
     * Get the path of the project.
     *
     * @return The path of the project.
     */
    String getProjectPath();
    
    /**
     * Get the path of the source code directory.
     *
     * @return The path of the source code directory.
     */
    String getSrcDirPath();
    
    /**
     * Get the path of the binary directories.
     *
     * @return The path of the binary directories.
     */
    String getBinDirPath();
    
    /**
     * Get the path of the libraries files.
     *
     * @return The path of the libraries files.
     */
    String getLibDirPath();
    
    /**
     * Get the path of the generated source files.
     *
     * @return The path of the generated source files.
     */
    String getGenDirPath();
    
    /**
     * Get the class path of the project.
     *
     * @return The class path of the project.
     */
    String getClassPath();
    
    /**
     * Get the path of the source files.
     *
     * @return The path of the source files.
     */
    String getSrcFiles();
}
