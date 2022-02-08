#!/usr/bin/env bash
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update

helm install nginx-ingress --namespace ingress-controller bitnami/nginx-ingress-controller \
  -f helm-configs/nginx-ingress.yml

helm install hw3-service --namespace otus-lab ./service-chart \
  --set global.postgresql.auth.postgresPassword=test-password

helm install postgres-metrics-exporter --namespace otus-lab prometheus-community/prometheus-postgres-exporter \
  -f helm-configs/postgres-exporter.yml

helm install prometheus --namespace prometheus prometheus-community/kube-prometheus-stack \
  -f helm-configs/prometheus.yml

