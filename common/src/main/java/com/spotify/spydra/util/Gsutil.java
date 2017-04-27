/*
 * Copyright 2017 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.spotify.spydra.util;

public class Gsutil {
  private static final String DEFAULT_GSUTIL_COMMAND = "gsutil";

  //Check to see if any files exist under the given path
  public static boolean checkIfFilesExist(String uri)
  {
    //Gsutil will return zero if files are found, non-zero otherwise
    ArrayList<String> command = Lists.newArrayList(
        "ls", uri);

    return this.execute(command);
  }
}

  private static boolean execute(List<String> commands)
      throws IOException {
      ArrayList<String> command = List.newArrayList(DEFAULT_GSUTIL_COMMAND);
      command.addAll(commands);

    return ProcessHelper.executeCommand(command) == Shell.SUCCESS;
  }

}