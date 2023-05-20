export class User {

    ID: number;
    Nome: string;
    Cognome: string;
    Citta: string;
    DataNascita: Date;

    constructor(
        ID: any,
        Nome: any,
        Cognome: any,
        Citta: any,
        DataNascita: any
    ) {
        this.ID = ID;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Citta = Citta;
        this.DataNascita = DataNascita;
    }

}
