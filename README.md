# React Spring Template
This is a CSR web app template, using React for the front end and Spring Boot for the back end.

## Set up
1. Clone this repo
2. In `client`, run `npm i terser` and `npm run build` to buld the React app
3. Open `server` in IntelliJ and edit application.yml to match your local MySQL config details
4. Run the Spring Boot project in IntelliJ, starting the Tomcat server
5. All URIs, including errors, should now redirect to the sample React app, other than `/api/**` or any files like `logo.png`

## Options
1. You can edit the `pom.xml` file to add more dependencies to Spring, like support for GraphQL
2. You can edit the `WebMvcConfiguration` class to modify the URI forwarding rules
3. You can edit the `error()` method in `MainController` class to modify the error redirection rules
