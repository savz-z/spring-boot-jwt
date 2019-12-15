import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieActionModalComponent } from './movie-action-modal.component';

describe('MovieActionModalComponent', () => {
  let component: MovieActionModalComponent;
  let fixture: ComponentFixture<MovieActionModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieActionModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieActionModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
