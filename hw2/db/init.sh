#!/usr/bin/env bash
helm repo add bitnami https://charts.bitnami.com/bitnami
minikube kubectl -- apply -f secret.yml
helm install -f db-values.yml postgres-lab --namespace otus-lab bitnami/postgresql
