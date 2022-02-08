#!/usr/bin/env bash
helm delete prometheus --namespace prometheus
helm delete postgres-metrics-exporter --namespace otus-lab
helm delete hw3-service --namespace otus-lab
helm delete nginx-ingress --namespace ingress-controller
kubectl delete pvc data-hw3-service-postgresql-0  --namespace otus-lab