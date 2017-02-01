import {Injectable} from '@angular/core';
import {Generation} from "../class/generation";
import {GENERATION} from "../mock/mock-generation";
import {Http, Headers, RequestOptions} from "@angular/http";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class GameOfLifeService {

  private getNextGenerationUrl = '/api/gof/getnextgeneration';
  private headers = new Headers({'Content-Type': 'application/json'});


  constructor(private http: Http) {
  }

  getNextGeneration(currentGeneration: Generation): Promise<Generation> {
    console.log("SERVICE:");
    console.log(currentGeneration);
    return this.http.post(this.getNextGenerationUrl, JSON.stringify(currentGeneration), {headers: this.headers})
      .toPromise()
      .then(response => {response.json().data as Generation; console.log(response)})
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

}
