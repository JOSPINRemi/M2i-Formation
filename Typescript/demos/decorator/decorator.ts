console.log("Les décorateurs");

function simpleDecoratorClass(target: Function): void {
  target.prototype.id = Math.random();
}

@simpleDecoratorClass
class UserWithDecorator {
  constructor(public name: string) {}
}

const user = new UserWithDecorator("Toto");
console.log(user);

//@ts-ignore
console.log(user.id);

console.clear();

function demoDecoratorMethod(...args: any): MethodDecorator {
  return function (
    target: Object,
    propertyKey: string | symbol,
    descriptor: PropertyDescriptor
  ) {
    console.log(target);
    console.log(propertyKey);
    console.log(descriptor);
    const originalMethod = descriptor.value;
    descriptor.value = (...args: any) => {
      const resultMethod = originalMethod.apply(target, args);
      return resultMethod + 2;
    };
  };
}

class Calculatrice {
  @demoDecoratorMethod()
  add(a: number, b: number) {
    return a + b;
  }
}

const maCalculatrice = new Calculatrice();

console.log(maCalculatrice.add(1, 1));
