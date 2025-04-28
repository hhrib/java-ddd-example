#!/bin/bash

# --- api_test.sh ---
# Uso: ./api_test.sh METHOD URL BODY_JSON

METHOD=$1
URL=$2
BODY=$3

if [ -z "$METHOD" ] || [ -z "$URL" ]; then
  echo "Usage: $0 METHOD URL [BODY_JSON]"
  echo "Example: $0 PUT http://localhost:8030/videos/abc123 '{\"title\": \"Course\", \"url\": \"http://codely.com\", \"text\": \"Hello\"}'"
  exit 1
fi

RESPONSE=$(curl -s -w "\nHTTP_STATUS_CODE:%{http_code}" \
  -X "$METHOD" "$URL" \
  -H "Content-Type: application/json" \
  -d "${BODY:-{}}" )

BODY_RESPONSE=$(echo "$RESPONSE" | sed '$d')
STATUS_CODE=$(echo "$RESPONSE" | tail -n1 | sed 's/HTTP_STATUS_CODE://')

echo "👉 Status Code: $STATUS_CODE"
echo "👉 Response Body:"
echo "$BODY_RESPONSE" | jq .

