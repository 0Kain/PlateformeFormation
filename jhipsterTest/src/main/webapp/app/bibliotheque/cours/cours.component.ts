import { Component, OnInit, Input } from '@angular/core';
import { ActuBoxCategorieModel } from '../../entities/actu-box-categorie.model';
import { ActuBoxModel } from '../../entities/actu-box.model';

@Component({
    selector: 'jhi-cours',
    templateUrl: './cours.component.html',
    styleUrls: ['./cours.component.scss']
})
export class CoursComponent implements OnInit {
    @Input() private actuBox: ActuBoxModel;
    private infoActu: ActuBoxModel;
    constructor() {}

    ngOnInit() {
        this.infoActu = this.actuBox;
    }
}
