# Base image
FROM node:lts-alpine

# Set working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy project files
COPY . .

# Expose port
EXPOSE 3000

# 실행 시 deprecation 경고 숨김
ENV NODE_OPTIONS="--no-deprecation"

# Start the app
CMD ["npm", "run", "dev"]