import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'jhi-actu-box',
    templateUrl: './actu-box.component.html',
    styles: []
})
export class ActuBoxComponent implements OnInit {
    private actuBox: string;
    private actuCateg: any;
    private infoActu: any;

    constructor() {
        this.actuBox = 'Crêpes';
        this.infoActu = {
            actuHeader: 'Boulangerie',
            actuCategs: [
                {
                    categName: 'informatique'
                },
                {
                    categName: 'pain'
                },
                {
                    categName: 'patisserie'
                }
            ],
            actuText: 'Allez les couch on se bouge le fion',
            actuDate: '20/10/2018'
        };
    }

    ngOnInit() {}
}
