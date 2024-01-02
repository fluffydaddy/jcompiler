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

public interface Project {
    void init(Map<String, FileHandle> resources) throws IOException;
    
    void clean();
    
    void delete();
    
    default boolean isRelease() {
        return false;
    }
    
    FileHandle export(boolean isCompiled);
    
    boolean exists();
    
    String getProjectName();
    
    String getProjectPath();
    
    String getSrcDirPath(); // src source code.
    
    String getBinDirPath(); // bin directories.
    
    String getLibDirPath(); // libraries files.
    
    String getGenDirPath(); // generate source files.
    
    String getClassPath();
    
    String getSrcFiles();
}