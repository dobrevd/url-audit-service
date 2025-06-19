# URL Audit Service

## Overview

The **URL Audit Service** is a microservice responsible for storing and providing access to event data.  
It is part of the **URL Shortener App** ecosystem, which includes the following microservices:

- **URL Shortener Service**: [GitHub Repository](https://github.com/dobrevd/url_shortener_service)
- **URL Frontend Angular Service**: [GitHub Repository](https://github.com/dobrevd/url-shortener-frontend)

All microservices in the URL Shortener App ecosystem will be deployed and run in a **Kubernetes** environment.

## Features

This microservice:

- Consumes events from **Kafka**
- Stores event data in **MongoDB**
- Provides REST API endpoints to serve data to the frontend
- Supports **pagination** for efficient data retrieval

#### 1. **Fetch All Data**

- Retrieves a complete list of all events from the server.
- **Pagination** support with options to display **5 (default)**.

#### 2. **Fetch Data by User and Date**

- Retrieves clicks/resolve events only based on:
    - A specific **User ID**
    - A specific **Date**
- Useful for detailed inspection of a user's activity on a given day.

## GitHub Actions Workflow

### 📌 Overview
This GitHub Actions workflow automates the **build and deployment** process for the Url Audit Service application.

### 🚀 Trigger Conditions
- Runs on **push** events to the `main` branch.

### 🛠️ Build Job (`build`)
✅ **Steps:**
- 🏗️ **Checkout Repository** – Clones the project repository.
- 🔧 **Set Permissions** – Grants execute permissions to the Gradle wrapper.
- ☕ **Set up JDK 17** – Installs Temurin JDK 17.
- ⚙️ **Configure Gradle** – Sets up Gradle for dependency management.
- 🏗️ **Build Project** – Runs `./gradlew build -x test` to compile the application.
- 📦 **Save Artifact** – Stores the generated JAR file for later use.

### 🐳 Docker Job (`docker`)
✅ **Steps:**
- 📥 **Download JAR Artifact** – Retrieves the built application from the previous job.
- 🔐 **Log in to Docker Hub** – Uses GitHub Secrets for authentication.
- 🏗️ **Build Docker Image** – Creates a Docker image for the application.
- 📤 **Push to Docker Hub** – Publishes the Docker image for deployment.

### 🔄 CI/CD Process
This workflow ensures **continuous integration and deployment**, making the application **automatically available as a Docker image** on every update to the `master` branch.

## 🧪 Code Coverage with JaCoCo

_**In development**_
