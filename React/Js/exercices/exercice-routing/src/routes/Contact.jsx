function Contact() {
  return (
    <main>
      <h2>Contact</h2>
      <form>
        <div>
          <label htmlFor="mail">Email : </label>
          <input type="email" id="mail" />
        </div>
        <div>
          <label htmlFor="message">Message : </label>
          <textarea name="" id="message" cols="30" rows="10"></textarea>
        </div>
        <button type="button">Envoyer le message</button>
      </form>
    </main>
  );
}

export default Contact;
