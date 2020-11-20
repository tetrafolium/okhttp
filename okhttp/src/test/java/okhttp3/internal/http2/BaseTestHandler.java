/*
 * Copyright (C) 2013 Square, Inc.
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
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;

import static org.junit.Assert.fail;

class BaseTestHandler implements Http2Reader.Handler {
  @Override public void data(final boolean inFinished, final int streamId, final BufferedSource source, final int length)
      throws IOException {
    fail();
  }

  @Override public void headers(final boolean inFinished, final int streamId, final int associatedStreamId,
      final List<Header> headerBlock) {
    fail();
  }

  @Override public void rstStream(final int streamId, final ErrorCode errorCode) {
    fail();
  }

  @Override public void settings(final boolean clearPrevious, final Settings settings) {
    fail();
  }

  @Override public void ackSettings() {
    fail();
  }

  @Override public void ping(final boolean ack, final int payload1, final int payload2) {
    fail();
  }

  @Override public void goAway(final int lastGoodStreamId, final ErrorCode errorCode, final ByteString debugData) {
    fail();
  }

  @Override public void windowUpdate(final int streamId, final long windowSizeIncrement) {
    fail();
  }

  @Override public void priority(final int streamId, final int streamDependency, final int weight,
      final boolean exclusive) {
    fail();
  }

  @Override
  public void pushPromise(final int streamId, final int associatedStreamId, final List<Header> headerBlock) {
    fail();
  }

  @Override public void alternateService(final int streamId, final String origin, final ByteString protocol,
      final String host, final int port, final long maxAge) {
    fail();
  }
}
