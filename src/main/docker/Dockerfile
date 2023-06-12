# Start with OL runtime.
FROM openliberty/open-liberty:full-java11-openj9-ubi
# FROM openliberty/open-liberty:microProfile3-ubi-min

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  org.opencontainers.image.authors="Rafael T. C. Soares" \
  org.opencontainers.image.vendor="IBM" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.source="https://github.com/OpenLiberty/guide-docker" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Open Liberty" \
  name="system" \
  version="$VERSION-$REVISION" \
  summary="The system microservice from the Docker Guide" \
  description="This image contains the system microservice running with the Open Liberty runtime."

USER root

COPY --chown=1001:0 src/main/liberty/config/server.xml /config/
# COPY --chown=1001:0 build/libs/*.war /config/apps/
COPY --chown=1001:0 build/libs/*.war /config/dropins

USER 1001