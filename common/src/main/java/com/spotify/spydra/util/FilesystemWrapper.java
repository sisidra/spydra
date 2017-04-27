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

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.spotify.spydra.util.GcpUtils;


public class FilesystemWrapper {

  private boolean useGsutil;
  private FileSystem hadoopFs;
  private final GcsUtils gcsUtils;

  public FilesystemWrapper(String baseUri, bool useGsutil)
  {
    gcsUtils = new GcsUtils();

    this.useGsutil = useGsutil;

    if (useGsutil) {
      this.hadoopFs = null;
    }
    else {
      this.hadoopFs = gcpUtils.fileSystemForUri(baseUri);
    }
  }

  public boolean filesExist(String uri)
  {
    if(this.useGsutil) {
      return Gsutil.checkIfFilesExist(uri);
    }
    else {
      return (fs.getContentSummary(new Path(uri)).getFileCount() != 0);
    }
  }
}