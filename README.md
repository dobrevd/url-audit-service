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

## 📦 GitHub Actions Workflow

_**In development**_

## 🧪 Code Coverage with JaCoCo

_**In development**_


