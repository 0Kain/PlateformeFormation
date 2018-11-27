import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
    selector: 'jhi-create-article',
    templateUrl: './create-article.component.html',
    styles: []
})
export class CreateArticleComponent implements OnInit {
    constructor(private http: HttpClient) {
        /*const btn = document.getElementById('createButton');
        btn.addEventListener('click', (e: Event) => this.validateArticle() );*/
    }

    ngOnInit() {}

    validateArticle() {
        const title = (document.getElementById('title') as HTMLInputElement).value;
        const topics = (document.getElementById('topics') as HTMLInputElement).value;
        const content = (document.getElementById('content') as HTMLInputElement).value;
        let params = new HttpParams()
            .set('title', title)
            .set('topics', topics)
            .set('content', content);
        this.http.post<any>(SERVER_API_URL + '/api/articles/create', { params: params }).subscribe(response => {
            alert(response);
            if (response) {
                // bandeau vert ça marche magnifique
                (document.getElementById('createSuccess') as HTMLInputElement).style.display = 'block';
                alert('ça marche');
            } else {
                alert('ça marche pas');
                // bandeau rouge ça marche pas moche
                (document.getElementById('createError') as HTMLInputElement).style.display = 'block';
            }
        });
    }
}
