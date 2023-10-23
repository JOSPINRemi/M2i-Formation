function sayHello(name) {
  console.log(`Hello ${name}`);
}

function sayHelloDate(name) {
  console.log(`Hello ${name}, on est le ${new Date().toLocaleDateString()}`);
}

module.exports = { sayHello, sayHelloDate };
