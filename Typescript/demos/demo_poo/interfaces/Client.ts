interface Client {
  firstname: string;
  lastname: string;
  numeroIdNat?: number; // propriété pas obligatoire : ?

  acheter?: () => number;
}

interface ClientRegulier extends Client {
  pointFid: number;
}

export {Client, ClientRegulier}
