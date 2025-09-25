# Use Microsoft's Java dev container as base (most reliable for Codespaces)
FROM mcr.microsoft.com/devcontainers/java:21

# Install Maven (if not already included)
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Install common dependencies
RUN apt-get update && \
    apt-get install -y wget gnupg2 curl unzip bzip2 software-properties-common && \
    rm -rf /var/lib/apt/lists/*

# Install Google Chrome
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Install Firefox using direct repository method (more reliable)
RUN wget -q -O - https://packages.mozilla.org/apt/repo-signing-key.gpg | apt-key add - && \
    echo "deb [arch=amd64] https://packages.mozilla.org/apt mozilla main" > /etc/apt/sources.list.d/mozilla.list && \
    apt-get update && \
    apt-get install -y firefox && \
    rm -rf /var/lib/apt/lists/*

# Install Microsoft Edge
RUN curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > /usr/share/keyrings/microsoft-archive.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/microsoft-archive.gpg] https://packages.microsoft.com/repos/edge stable main" > /etc/apt/sources.list.d/microsoft-edge.list && \
    apt-get update && \
    apt-get install -y microsoft-edge-stable && \
    rm -rf /var/lib/apt/lists/*

# Note: EdgeDriver will be installed manually after container is running
# This avoids build failures due to version mismatches

# Default workdir
WORKDIR /workspaces/selenium-java-codespaces