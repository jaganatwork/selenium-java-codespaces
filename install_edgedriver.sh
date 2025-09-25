#!/bin/bash
set -e
echo "--- Fetching latest Edge Driver version..."
LATEST_EDGE_RELEASE=$(curl -s https://edgedriver.azureedge.net/LATEST_STABLE | tr -d '\r')
echo "--- Latest version is: ${LATEST_EDGE_RELEASE}"
echo "--- Downloading driver..."
wget -q "https://msedgedriver.azureedge.net/${LATEST_EDGE_RELEASE}/edgedriver_linux64.zip" -O /tmp/edgedriver.zip
echo "--- Unzipping driver..."
sudo unzip /tmp/edgedriver.zip -d /usr/local/bin/
echo "--- Cleaning up..."
rm /tmp/edgedriver.zip
echo "--- Setting permissions..."
sudo chmod +x /usr/local/bin/msedgedriver
echo "--- Edge Driver Installed Successfully ---"
msedgedriver --version
