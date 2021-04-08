#!/usr/bin/env bash
#
#  Installer for WebDrivers
#  ------------------------
#  - Binary webdrivers are required to drive Firefox and Chrome browsers from Selenium.
#  - This script will fetch the 64-bit binaries (geckodriver/chromedriver) for MacOS or Linux.

set -e


install_dir="/usr/local/bin"


if [[ $(uname -m) != "x86_64" ]]; then
    echo "unsupported machine architecture"
    exit 1
fi


json=$(curl -s https://api.github.com/repos/mozilla/geckodriver/releases/latest)
if [[ $(uname) == "Darwin" ]]; then
    geckodriver_url=$(echo "$json" | jq -r '.assets[].browser_download_url | select(contains("macos"))')
elif [[ $(uname) == "Linux" ]]; then
    geckodriver_url=$(echo "$json" | jq -r '.assets[].browser_download_url | select(contains("linux64"))')
else
    echo "unsupported operating system"
    exit 1
fi
curl -s -L $geckodriver_url | tar -xz
chmod +x geckodriver
sudo mv geckodriver "$install_dir"
echo "installed geckodriver binary in '$install_dir'"


base_url="http://chromedriver.storage.googleapis.com"
version=$(curl -s $base_url/LATEST_RELEASE)
if [[ $(uname) == "Darwin" ]]; then
    chromedriver_url="$base_url/$version/chromedriver_mac64.zip"
elif [[ $(uname) == "Linux" ]]; then
    chromedriver_url="$base_url/$version/chromedriver_linux64.zip"
else
    echo "unsupported operating system"
    exit 1
fi
curl -s -L $chromedriver_url | tar -xf- -C .      
chmod +x chromedriver
sudo mv chromedriver "$install_dir"
echo "installed chromedriver binary in '$install_dir'"


echo "done."
