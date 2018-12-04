import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActuBoxModel } from '../entities/actu-box.model';

@Component({
    selector: 'jhi-bibliotheque',
    templateUrl: './bibliotheque.component.html',
    styleUrls: ['bibliotheque.component.scss']
})
export class BibliothequeComponent implements OnInit {
    http: HttpClient;
    infosActus: Array<ActuBoxModel>;
    constructor(private _http: HttpClient) {
        this.http = _http;
        this.http.get('http://localhost:9000/data.json').subscribe((result: Array<ActuBoxModel>) => {
            //observable/promise : s'abonner à un event et on attend la reception des données et on peut faire un traitement après
            this.infosActus = result;
        });
    }
    ngOnInit() {}
}
