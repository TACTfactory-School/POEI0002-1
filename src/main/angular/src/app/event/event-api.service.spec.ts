// import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
// import { RouterTestingModule } from '@angular/router/testing';
import { TestBed, fakeAsync, tick } from '@angular/core/testing';
import { EventApiService } from './event-api.service';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { of } from 'rxjs';

const fakeEvents = [{
  id: 1,
  label: 'BBQ',
  author: 'Ohil',
  description: 'Super',
  finished: false
}, {
  id: 2,
  label: 'Zelda tour',
  author: 'Link',
  description: 'On va retrouver les 8 cristaux de ...',
  finished: true
}];

const httpClient = {
  delete: () => of(null),
  get: (url: string) => {
    if (url.match(/event\/\d+/)) {
      return of(fakeEvents[0]);
    } else {
      return of(fakeEvents);
    }
  }
};

describe('EventApiService', () => {
  let service: EventApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule,
        // HttpClientTestingModule,
        // RouterTestingModule
      ],
      providers: [
        {provide: HttpClient, useValue: httpClient}
      ]
    });

    service = TestBed.get(EventApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call get for getOne', fakeAsync(() => {
    let data: any;
    service.getOne(1).subscribe(d => data = d);
    tick(500);
    expect(data).toEqual(fakeEvents[0]);
  }));

  it('should call delete', fakeAsync(() => {
    let called = false;
    service.deleteOne(1).subscribe(() => called = true);
    tick(500);
    expect(called).toBeTruthy();
  }));
});

// describe('HttpClient testing', () => {
//   let httpClient: HttpClient;
//   let httpTestingController: HttpTestingController;

//   beforeEach(() => {
//     TestBed.configureTestingModule({
//       imports: [ HttpClientTestingModule ]
//     });

//     // Inject the http service and test controller for each test
//     httpClient = TestBed.get(HttpClient);
//     httpTestingController = TestBed.get(HttpTestingController);
//   });

//   /// Tests begin ///
//   it('can test HttpClient.get', () => {
//     const testData: Event = {label: 'test'};

//     // Make an HTTP GET request
//     httpClient.get<Event[]>('./assets/fixtureEvent.json)
//       .subscribe(data =>
//         // When observable resolves, result should match test data
//         expect(data).toEqual(testData)
//       );

//     // The following `expectOne()` will match the request's URL.
//     // If no requests or multiple requests matched that URL
//     // `expectOne()` would throw.
//     const req = httpTestingController.expectOne('/data');

//     // Assert that the request is a GET.
//     expect(req.request.method).toEqual('GET');

//     // Respond with mock data, causing Observable to resolve.
//     // Subscribe callback asserts that correct data was returned.
//     req.flush(testData);

//     // Finally, assert that there are no outstanding requests.
//     httpTestingController.verify();
//   });

//   afterEach(() => {
//     // After every test, assert that there are no more pending requests.
//     httpTestingController.verify();
//   });
// });
