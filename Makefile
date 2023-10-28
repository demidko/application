run-application: build-backend
	java -jar backend/build/libs/backend-boot.jar

build-backend: build-frontend
	cd backend && gradle clean build

build-frontend:
	cd frontend && npm run build && rsync -a --delete ./dist/ ../backend/src/main/resources/public/