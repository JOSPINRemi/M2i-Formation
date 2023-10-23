import http from "http";

const server = http.createServer((req, res) => {
  const { method } = req;

  if (method === "GET") {
    res.writeHead(200, { "Content-Type": "application/json" });
    res.end("{'firstname': 'toto', 'lastname': 'tata'}");
  } else {
    res.writeHead(500, { "Content-Type": "application/json" });
    res.end("Mauvaise méthode HTTP");
  }
});

server.listen(3030);
console.log("listening on port http://127.0.0.1:3030");
