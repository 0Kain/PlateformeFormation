import { Component, OnInit, Input } from '@angular/core';
import { ActuBoxCategorieModel } from '../../entities/actu-box-categorie.model';
import { ActuBoxModel } from '../../entities/actu-box.model';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'jhi-actu-box',
    templateUrl: './actu-box.component.html',
    styleUrls: ['actu-box.component.scss']
})
export class ActuBoxComponent implements OnInit {
    //private infoActu: ActuBoxModel;

    @Input() private actuBox: ActuBoxModel;
    private infoActu: ActuBoxModel;
    constructor() {
        // Je mets à disposition le service au component
        //parametre sont chiffrés dans l'url
        /* OldVersion without data
        const actuCategs: Array<ActuBoxCategorieModel> = [];
        actuCategs.push(new ActuBoxCategorieModel('informatique'));
        actuCategs.push(new ActuBoxCategorieModel('pain'));
        actuCategs.push(new ActuBoxCategorieModel('patisserie'));

        this.infoActu = new ActuBoxModel('Boulangerie', actuCategs, 'Allez les couch on se bouge le fion', '21/10/2018');*/
    }

    ngOnInit() {
        this.infoActu = this.actuBox;
    }
}
