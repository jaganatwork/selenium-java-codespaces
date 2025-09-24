# Base image with Java 21 + Maven
FROM maven:3.9.6-eclipse-temurin-21

# Install Chrome + deps
RUN apt-get update && \
    apt-get install -y wget gnupg2 curl unzip bzip2 && \
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Fix: Install Firefox (non-snap) by adding the Mozilla PPA
RUN apt-get update && \
    apt-get install -y --no-install-recommends software-properties-common && \
    add-apt-repository ppa:mozillateam/ppa -y && \
    echo 'Package: *' > /etc/apt/preferences.d/mozillateam-ppa && \
    echo 'Pin: release o=LP-PPA-mozillateam' >> /etc/apt/preferences.d/mozillateam-ppa && \
    echo 'Pin-Priority: 1001' >> /etc/apt/preferences.d/mozillateam-ppa && \
    apt-get update && \
    apt-get install -y firefox && \
    rm -rf /var/lib/apt/lists/*

# Default workdir
WORKDIR /workspaces/selenium-java-codespaces