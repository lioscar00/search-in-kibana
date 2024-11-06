package com.canva.intellij.searchinkibana;

public class SearchInKibanaStagingCnAction extends AbstractSearchInKibanaAction {
  public SearchInKibanaStagingCnAction() {
    super("https://logs.canva-corp.cn/_plugin/kibana/app/discover#/?_g=(filters:!(),"
        + "refreshInterval:(pause:!t,value:0),time:(from:now-3d,to:now))&_a=(columns:!"
        + "(_source),filters:!(),index:'d8ef2010-126c-11eb-a721-17d2c4b8b635',interval:auto,"
        + "query:(language:kuery,query:'%s'),sort:!())");
  }
}
