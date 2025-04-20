FROM openjdk:21-slim-buster
WORKDIR /app

# Instalar herramientas necesarias sin usar curl
RUN apt update && apt install -y wget xz-utils git ca-certificates && \
    rm -rf /var/lib/apt/lists/*

# Descargar e instalar Node.js 18
RUN wget --no-check-certificate https://nodejs.org/dist/v18.0.0/node-v18.0.0-linux-x64.tar.xz && \
    tar -xJf node-v18.0.0-linux-x64.tar.xz -C /usr/local --strip-components=1 && \
    rm node-v18.0.0-linux-x64.tar.xz

# Asegurar que node y npm estén en el PATH
ENV PATH="/usr/local/bin:$PATH"

# Verificación opcional
RUN node -v && npm -v && java -version
