#!/usr/bin/env bash
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
helm install hw3-service --namespace otus-lab ./service-chart --set db.password=test-password
helm install postgres-lab --namespace otus-lab bitnami/postgresql --set auth.existingSecret=postgres-secret
helm install prometheus --namespace otus-lab prometheus-community/kube-prometheus-stack \
  --set prometheus.prometheusSpec.serviceMonitorSelectorNilUsesHelmValues=false \
  --set prometheus.prometheusSpec.serviceMonitorSelector={}

