#!/usr/bin/env bash
#minikube kubectl -- create namespace otus-lab
#helm repo add bitnami https://charts.bitnami.com/bitnami
minikube kubectl -- apply -f secret.yml
helm install -f db-values.yml postgres-lab --namespace otus-lab bitnami/postgresql
