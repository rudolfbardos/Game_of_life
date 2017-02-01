import { GameOfLifeFrontendPage } from './app.po';

describe('game-of-life-frontend App', function() {
  let page: GameOfLifeFrontendPage;

  beforeEach(() => {
    page = new GameOfLifeFrontendPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
