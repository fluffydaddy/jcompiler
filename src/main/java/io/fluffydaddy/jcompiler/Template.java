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

/**
 * Interface for creating and managing projects using a template.
 */
public interface Template {
    /**
     * Create a new project with the specified name.
     *
     * @param projectName The name of the new project.
     * @return The created project.
     * @throws IOException If an I/O error occurs during project creation.
     */
    Project makeProject(String projectName) throws IOException;
    
    /**
     * Open an existing project with the specified name.
     *
     * @param projectName The name of the existing project to open.
     * @return The opened project.
     */
    Project openProject(String projectName);
    
    /**
     * Exit from the project with the specified name.
     *
     * @param projectName The name of the project to exit.
     * @return The exited project.
     */
    Project exitProject(String projectName);
    
    /**
     * Get the handle to the directory containing all projects.
     *
     * @return The handle to the projects directory.
     */
    FileHandle getProjects();
}
