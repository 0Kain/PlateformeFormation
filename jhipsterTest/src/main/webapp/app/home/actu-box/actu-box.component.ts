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
    @Input() private actuBox: ActuBoxModel;
    private infoActu: ActuBoxModel;
    constructor() {}

    ngOnInit() {
        this.infoActu = this.actuBox;
    }
}
