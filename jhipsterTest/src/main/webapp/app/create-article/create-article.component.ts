import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders, HttpParams } from '@angular/common/http';

@Component({
    selector: 'jhi-create-article',
    templateUrl: './create-article.component.html',
    styles: []
})
export class CreateArticleComponent implements OnInit {
    constructor(private http: HttpClient) {}

    /*this.http.post<any>(path,params).subscribe((response)=>if(response){
        //magnifique bandeau vert ça marche
    }else{
        //bandeau rouge ça marche pas moche
    })*/

    ngOnInit() {}
}
