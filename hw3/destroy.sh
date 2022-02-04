#!/usr/bin/env bash
helm delete hw3-service --namespace otus-lab
helm delete postgres-lab --namespace otus-lab
helm delete prometheus --namespace otus-lab
kubectl delete pvc data-postgres-lab-postgresql-0 --namespace otus-lab
