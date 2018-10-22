import { ActuBoxCategorieModel } from './actu-box-categorie.model';
export class ActuBoxModel {
    private actuHeader: String;
    private actuCategs: Array<ActuBoxCategorieModel>;
    private actuText: String;
    private actuDate: String;
    constructor(
        private _actuHeader: String,
        private _actuCategs: Array<ActuBoxCategorieModel>,
        private _actuText: String,
        private _actuDate: String
    ) {
        this.actuHeader = _actuHeader;
        this.actuCategs = _actuCategs;
        this.actuText = _actuText;
        this.actuDate = _actuDate;
    }
}
