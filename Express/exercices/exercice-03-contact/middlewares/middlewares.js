export function authMiddleware(req, res, next) {
  let user = req.body.user;
  let password = req.body.password;
  if (user !== "admin" || password !== "password") {
    res.sendStatus(401);
  }
  next();
}

export function dateMiddleware(req, res, next) {
  req.dateRequest = new Date();
  next();
}
