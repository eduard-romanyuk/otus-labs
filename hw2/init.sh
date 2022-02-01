#!/usr/bin/env bash
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install hw2-service --namespace otus-lab ./service-chart --set db.password=test-password
helm install postgres-lab --namespace otus-lab bitnami/postgresql --set existingSecret=postgres-secret
