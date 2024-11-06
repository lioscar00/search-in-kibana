package com.canva.intellij.searchinkibana;

public class SearchInKibanaProdCnAction extends AbstractSearchInKibanaAction {
  public SearchInKibanaProdCnAction() {
    super("https://logs.canva-corp.cn/_plugin/kibana/app/discover#/?_g=(filters:!(),"
        + "refreshInterval:(pause:!t,value:0),time:(from:now-3d,to:now))&_a=(columns:!"
        + "(_source),filters:!(),index:'e4d4d900-0c55-11eb-8333-49f0f1d537b4',interval:auto,"
        + "query:(language:kuery,query:'%s'),sort:!())");
  }
}
